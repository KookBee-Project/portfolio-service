package com.KookBee.portfolioservice.exception;

public class ProjectJoinStatusCheckException extends Exception{
    public ProjectJoinStatusCheckException(){super("이미 시작되었거나 종료된 프로젝트입니다.");}
}
