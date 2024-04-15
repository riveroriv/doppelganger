package com.riveroriv.doppelganger.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mock {
    private String method;
    private String path;
    private String response;
    private Integer status;
    private String type = "application/json;charset=utf-8";
}
