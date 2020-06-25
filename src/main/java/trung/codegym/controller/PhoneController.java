package trung.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import trung.codegym.model.Phone;

import javax.validation.Valid;

@Controller
public class PhoneController {

    @GetMapping("/")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phoneNumber", new Phone());
        return modelAndView;
    }

    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")Phone phone, BindingResult bindingResult, Model model){
        new Phone().validate(phone, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        else {
            model.addAttribute("phoneNumber", phone);
            return "result";
        }
    }
}
