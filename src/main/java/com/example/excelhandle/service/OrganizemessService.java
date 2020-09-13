package com.example.excelhandle.service;

import com.example.excelhandle.pojo.Organizemess;
import org.springframework.web.multipart.MultipartFile;

public interface OrganizemessService {

    /*
     @description:组织结构信息
     @author:qiaoyn
     @date:2019/06/04
   */
    int insert(Organizemess organizemess);

    /*
     * 读取excel文件
     * */
    String readExcelFile(MultipartFile file);
}
