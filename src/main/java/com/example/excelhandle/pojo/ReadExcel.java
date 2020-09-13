package com.example.excelhandle.pojo;

public class ReadExcel {
    //总行数
    private int totalRows = 0;

    //总条数
    private int totalCells = 0;

    //错误信息的收集类
    private String errorMsg;

    public ReadExcel() {
    }

    public ReadExcel(int totalRows, int totalCells, String errorMsg) {
        this.totalRows = totalRows;
        this.totalCells = totalCells;
        this.errorMsg = errorMsg;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalCells() {
        return totalCells;
    }

    public void setTotalCells(int totalCells) {
        this.totalCells = totalCells;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
