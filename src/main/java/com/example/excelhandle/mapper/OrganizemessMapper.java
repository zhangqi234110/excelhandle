package com.example.excelhandle.mapper;

import com.example.excelhandle.pojo.Organizemess;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizemessMapper {
    int insert(Organizemess organizemess);
}
