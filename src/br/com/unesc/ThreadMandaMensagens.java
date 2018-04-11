package br.com.unesc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class ThreadMandaMensagens extends Thread {
  private static final int TAMANHO_MAXIMO_LISTA = 5;
  private Vector messages = new Vector();

  public void run() {
    try {
      while (true) {
        insereMensagemNaLista();
        sleep(1000);
      }
    } catch (InterruptedException e) {
    }
  }

  private synchronized void insereMensagemNaLista()
          throws InterruptedException {

    while (messages.size() == TAMANHO_MAXIMO_LISTA)
      wait();
    LocalDateTime agora = LocalDateTime.now();
    messages.addElement(agora.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    notify();
  }

  public synchronized String pegaPrimeiraMensagem()
          throws InterruptedException {
    notify();
    while (messages.size() == 0)
      wait();
    String message = (String) messages.firstElement();
    messages.remove(message);
    return message;
  }
}
