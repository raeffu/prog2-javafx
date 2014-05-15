package clock;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;

public class Worker extends Thread {

  private IntegerProperty _secProp;
  private IntegerProperty _minProp;
  private IntegerProperty _hrsProp;

  private int _secCounter, _minCounter, _hrsCounter;

  public Worker(IntegerProperty secProp, IntegerProperty minProp,
      IntegerProperty hrsProp) {
    _secProp = secProp;
    _minProp = minProp;
    _hrsProp = hrsProp;
    start();
  }

  public void run() {
    while (true) {
      _secCounter++;

      if (_secCounter < 60) {
        Platform.runLater(new Runnable() {
          public void run() {
            _secProp.set(_secCounter);
          }
        });
      }
      else {
        _secCounter = 0;
        _minCounter++;

        if (_minCounter < 60) {
          Platform.runLater(new Runnable() {
            public void run() {
              _minProp.set(_minCounter);
            }
          });
        }
        else {
          _minCounter = 0;
          _hrsCounter++;

          if (_hrsCounter >= 24)
            _hrsCounter = 0;
          
          Platform.runLater(new Runnable() {
            public void run() {_hrsProp.set(_hrsCounter);}
          });
        }
      }

      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
