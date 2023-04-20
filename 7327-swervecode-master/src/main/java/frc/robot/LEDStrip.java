package frc.robot;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;


public class LEDStrip {
    

    public class ledStrip {
        private final AddressableLED m_ledLights;
        private final AddressableLEDBuffer m_ledLightsBuffer; // how many LED lights in strip
        private int initRainbowHue = 0;

      /*
      // Stages 
        autonomous: rainbow
        pipeline 0: burgundy (April Tags)
        pipeline 1: gold (retro tape)
        human player: purple (cube) | yellow (cone)
        aligned (teleop): Green
        charge station: burgundy and gold
      */  

      public ledStrip() {
        m_ledLights = new AddressableLED(0);
        m_ledLightsBuffer = new AddressableLEDBuffer(60);

        m_ledLights.setLength(m_ledLightsBuffer.getLength());
        m_ledLights.setData(m_ledLightsBuffer);
        m_ledLights.start();
      }

      public void setBurgundy() { // when in pipeline 0: April tags
        m_ledLightsBuffer.setRGB(0, 128, 0, 32);
        m_ledLights.setData(m_ledLightsBuffer);
      }
    
      public void setGold() { // when in pipeline 1: retroreflective tape
        m_ledLightsBuffer.setRGB(0, 255, 209, 0);
        m_ledLights.setData(m_ledLightsBuffer);
      }
    
      public void setGreen() {
        m_ledLightsBuffer.setRGB(0, 0, 255, 0);
        m_ledLights.setData(m_ledLightsBuffer);
      }

      public void rainbow(){
        for (var i = 0; i < m_ledLightsBuffer.getLength(); i++){
            final int hue = (initRainbowHue + (i * 180 / m_ledLightsBuffer.getLength())) % 180;
            m_ledLightsBuffer.setHSV(i, hue, 255, 128);
        }

        initRainbowHue += 3; //inc every 3 leds (flow pattern)
        initRainbowHue %= 180;
        m_ledLights.setData(m_ledLightsBuffer);
      }

      
    }

}
