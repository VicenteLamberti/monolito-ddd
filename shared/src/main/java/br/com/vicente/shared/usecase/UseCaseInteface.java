package br.com.vicente.shared.usecase;

public interface UseCaseInteface<INPUT,OUTPUT> {
    OUTPUT execute (INPUT input);
}
