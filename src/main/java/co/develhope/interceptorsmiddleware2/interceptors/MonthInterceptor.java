package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private static List<Month> months = Arrays.asList(
            new Month(1, "January", "Gennaio", "Januar"),
            new Month(2, "February", "Febbraio", "Februar"),
            new Month(3, "March", "Marzo", "März"),
            new Month(4, "April", "Aprile", "April"),
            new Month(5, "May", "Maggio", "Mai"),
            new Month(6, "June", "Giugno", "Juni"));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberString = request.getHeader("monthNumber");
        if(monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write("Error Bad Request - HTTP Status Code: " + HttpStatus.BAD_REQUEST.value());
            return false;
        } else {
            Integer monthNumber = Integer.parseInt(monthNumberString);
            Optional<Month> month = months.stream().filter(currentMonth -> currentMonth.getMonthNumber() == monthNumber).findFirst();
            if(month.isPresent()) {
                request.setAttribute("month", month.get());
            } else {
                request.setAttribute("month", new Month(null, "nope", "nope", "nope"));
            }
        }
        response.setStatus(HttpStatus.OK.value());
        return true;
    }

}