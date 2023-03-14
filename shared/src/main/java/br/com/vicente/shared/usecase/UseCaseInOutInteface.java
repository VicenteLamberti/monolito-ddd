package br.com.vicente.shared.usecase;

public interface UseCaseInOutInteface<INPUT,OUTPUT> {
    OUTPUT execute (INPUT input);
}
