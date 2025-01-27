package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Feeder extends SubsystemBase {
  DigitalInput FeederSensor = new DigitalInput(1);
  TalonFX Feeder = new TalonFX(1);

  public Feeder() {}
  
  public boolean getStatus() {
    return FeederSensor.get();
  }

  public void runFeeder(double speed) {
    Feeder.set(speed);
  }

  @Override
  public void periodic() {
  }
}
