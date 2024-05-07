package roomescape.service;

import org.springframework.stereotype.Service;
import roomescape.domain.ReservationTime;
import roomescape.exception.IllegalUserRequestException;
import roomescape.repository.ReservationRepository;
import roomescape.repository.ReservationTimeRepository;
import roomescape.service.dto.ReservationTimeSaveRequest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationTimeService {

    private final ReservationTimeRepository reservationTimeRepository;
    private final ReservationRepository reservationRepository;

    public ReservationTimeService(ReservationTimeRepository reservationTimeRepository, ReservationRepository reservationRepository) {
        this.reservationTimeRepository = reservationTimeRepository;
        this.reservationRepository = reservationRepository;
    }

    public ReservationTime createReservationTime(ReservationTimeSaveRequest request) {
        if (reservationTimeRepository.findByStartAt(request.startAt()).isPresent()) {
            throw new IllegalUserRequestException("이미 존재하는 예약 시간입니다.");
        }

        ReservationTime newReservationTime = ReservationTimeSaveRequest.toEntity(request);
        return reservationTimeRepository.save(newReservationTime);
    }

    public List<ReservationTime> findReservationTimes() {
        return reservationTimeRepository.findAll();
    }

    public Map<ReservationTime, Boolean> findIsBooked(LocalDate date, Long themeId) {
        List<ReservationTime> reservedTimes = reservationTimeRepository.findReservedBy(date, themeId);
        Map<ReservationTime, Boolean> isBooked = new HashMap<>();
        for (ReservationTime reservationTime : reservationTimeRepository.findAll()) {
            isBooked.put(reservationTime, isReserved(reservedTimes, reservationTime));
        }
        return isBooked;
    }

    private boolean isReserved(List<ReservationTime> reservedTimes, ReservationTime reservationTime) {
        return reservedTimes.stream()
                .anyMatch(reservedTime -> reservedTime.isSameReservationTime(reservationTime.getId()));
    }

    public void deleteReservationTime(Long id) {
        if (reservationRepository.existsByReservationTimeId(id)) {
            throw new IllegalUserRequestException("이미 예약중인 시간은 삭제할 수 없습니다.");
        }
        int deletedCount = reservationTimeRepository.deleteById(id);
        if (deletedCount == 0) {
            throw new IllegalUserRequestException("존재하지 않는 예약 시간입니다.");
        }
    }
}
