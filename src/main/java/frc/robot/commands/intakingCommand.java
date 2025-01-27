package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;

public class intakingCommand extends Command {
  Intake mIntake;
  double mIntakeSpeed;
  Feeder mFeeder;
  double mFeederSpeed;
  
  public intakingCommand(Intake Intake, double IntakeSpeed, Feeder Feeder, double FeederSpeed) {
    this.mIntake = Intake;
    this.mIntakeSpeed = IntakeSpeed;
    this.mFeeder = Feeder;
    this.mFeederSpeed = FeederSpeed;
    addRequirements(Intake, Feeder);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mIntake.runIntake(mIntakeSpeed);
    if (mIntake.getStatus() && mFeeder.getStatus()) {
      mIntake.runIntake(0);
      mFeeder.runFeeder(0);
    }
    else {
      mIntake.runIntake(mIntakeSpeed);
      mFeeder.runFeeder(mFeederSpeed);
    }
  }

  @Override
  public void end(boolean interrupted) {
    mIntake.runIntake(0);
    mFeeder.runFeeder(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}