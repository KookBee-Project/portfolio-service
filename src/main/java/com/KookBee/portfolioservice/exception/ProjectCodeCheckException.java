package com.KookBee.portfolioservice.exception;

public class ProjectCodeCheckException extends Exception{
    public ProjectCodeCheckException() {
        super("잘못된 코드를 입력하셨습니다");
    }
}
