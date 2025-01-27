package frc.robot;

import frc.robot.commands.intakingCommand;
import frc.robot.commands.IntakeAngleCommand;
import frc.robot.subsystems.Feeder;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakeAngle;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  Joystick PS5 = new Joystick(0);
  Intake IntakeKraken = new Intake();
  Feeder FeederKraken = new Feeder();
  IntakeAngle IntakeAngleKraken = new IntakeAngle();
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    new JoystickButton(PS5, 1).whileTrue(new intakingCommand(IntakeKraken, 1, FeederKraken, 1));
    new JoystickButton(PS5, 2).whileTrue(new intakingCommand(IntakeKraken, -1, FeederKraken, -1));
    new JoystickButton(PS5, 3).onTrue(new IntakeAngleCommand(IntakeAngleKraken, 25));
    new JoystickButton(PS5, 4).onTrue(new IntakeAngleCommand(IntakeAngleKraken, 0));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
