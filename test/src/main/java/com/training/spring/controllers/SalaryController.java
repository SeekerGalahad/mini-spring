package com.training.spring.controllers;

import com.training.spring.beans.Autowired;
import com.training.spring.service.SalaryService;
import com.training.spring.web.mvc.Controller;
import com.training.spring.web.mvc.RequestMapping;
import com.training.spring.web.mvc.RequestParam;

/**
 * @author Wagic
 * @date 2019-06-27 10:47 by Wagic 创建
 */
@Controller
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/get_salary.json")
    public int getSalary(@RequestParam("name") String name,
                         @RequestParam("experience") String experience) {
        return salaryService.calSalary(Integer.parseInt(experience));
    }
}
