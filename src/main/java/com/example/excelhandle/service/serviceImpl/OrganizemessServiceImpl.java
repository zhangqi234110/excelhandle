package com.example.excelhandle.service.serviceImpl;

import com.example.excelhandle.mapper.OrganizemessMapper;
import com.example.excelhandle.pojo.Organizemess;
import com.example.excelhandle.service.OrganizemessService;
import com.example.excelhandle.util.OrganizeExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class OrganizemessServiceImpl implements OrganizemessService {

    @Autowired
    private OrganizemessMapper organizemessMapper;

    @Override
    public int insert(Organizemess organizemess) {
        return organizemessMapper.insert(organizemess);
    }


    /*
      @description:excel文件导入
      @author:qiaoyn
      @date:2019/06/13
    */
    @Override
    public String readExcelFile(MultipartFile file) {
        String result = "";
        OrganizeExcelUtil excel = new OrganizeExcelUtil();
        List<Organizemess> ilist = excel.getExcelInfo(file);
        if (ilist != null && !ilist.isEmpty()) {
            //不为空的话添加到数据库
            for (Organizemess organizemess : ilist) {
                organizemessMapper.insert(organizemess);
            }
            result = "上传成功";
        } else {
            result = "上传失败";
        }
        return result;
    }
}
