package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase {
  DigitalInput intakeSensor = new DigitalInput(0);
  TalonFX Intake = new TalonFX(1);

  public Intake() {}
  
  public boolean getStatus() {
    return intakeSensor.get();
  }

  public void runIntake(double speed) {
    Intake.set(speed);
  }

  @Override
  public void periodic() {
  }
}
