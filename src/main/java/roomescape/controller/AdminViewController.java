package roomescape.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @GetMapping
    public String adminPage() {
        return "admin/index";
    }

    @GetMapping("/time")
    public String reservationTimeAdminPage() {
        return "/admin/time";
    }

    @GetMapping("/reservation")
    public String reservationAdminPage() {
        return "admin/reservation-new";
    }

    @GetMapping("/theme")
    public String themeAdminPage() {
        return "admin/theme";
    }
}
