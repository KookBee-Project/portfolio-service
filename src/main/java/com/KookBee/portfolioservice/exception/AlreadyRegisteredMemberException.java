package com.KookBee.portfolioservice.exception;

public class AlreadyRegisteredMemberException extends Exception{
    public AlreadyRegisteredMemberException() {super("이미 가입되어 있는 회원입니다.");}
}
