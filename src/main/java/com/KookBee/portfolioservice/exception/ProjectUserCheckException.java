package com.KookBee.portfolioservice.exception;

public class ProjectUserCheckException extends Exception{
    public ProjectUserCheckException(){
        super("이미 등록되어있는 강의입니다!");
    }
}
