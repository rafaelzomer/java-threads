package br.com.unesc;

public class ThreadRecebeMensagens extends Thread {

  private ThreadMandaMensagens threadMandaMensagens;

  ThreadRecebeMensagens(ThreadMandaMensagens p) {
    threadMandaMensagens = p;
  }

  public void run() {
    try {
      while (true) {
        String message = threadMandaMensagens.pegaPrimeiraMensagem();
        System.out.println("Mensagem recebida: " + message);
        sleep(2000);
      }
    } catch (InterruptedException e) {
    }
  }
}
