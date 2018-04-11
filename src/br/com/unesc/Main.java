package br.com.unesc;

public class Main {
  public static void main(String args[]) {
    ThreadMandaMensagens threadMandaMensagens = new ThreadMandaMensagens();
    threadMandaMensagens.start();
    ThreadRecebeMensagens threadRecebeMensagens = new ThreadRecebeMensagens(threadMandaMensagens);
    threadRecebeMensagens.start();
  }
}
