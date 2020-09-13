package com.example.excelhandle.controller;

import com.example.excelhandle.service.OrganizemessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "组织结构信息录入")
@RequestMapping(value = "/organize")
public class OrganizemessController {

    @Autowired
    private OrganizemessService organizemessService;

    /**
     * 文件上传
     * @param file
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "文件上传", notes = "/文件上传")
    @RequestMapping(value="/uploadExcel",method = RequestMethod.POST)
    public String uploadExcel(@RequestParam(value="file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String result = organizemessService.readExcelFile(file);
        return result;
    }

}
