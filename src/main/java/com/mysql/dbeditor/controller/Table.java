package com.mysql.dbeditor.controller;

import com.mysql.dbeditor.repository.TableSampleRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Table {
    TableSampleRepo tableSampleRepo = new TableSampleRepo();
    @GetMapping("table")
    public ModelAndView table(ModelAndView modelAndView){
        modelAndView.setViewName("tables.jsp");
        List<String> columns = tableSampleRepo.getColumnNamesOfATable("berkay", "countrydata");
        List<List<String>> rows = tableSampleRepo.getRowsOfATable("berkay","countrydata");
        modelAndView.addObject("columns", columns);
        modelAndView.addObject("rows", rows);

        return modelAndView;
    }
}
