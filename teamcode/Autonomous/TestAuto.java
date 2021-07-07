package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Components.RobotHardware;
import org.firstinspires.ftc.teamcode.GorillabotsCentral;
@Disabled
@Autonomous(group = "test", name = "TestAuto")

public class TestAuto extends GorillabotsCentral {
    public void runOpMode() {

        Servo grabber;
        grabber = hardwareMap.get(Servo.class, "grabber");
        final double Grabber_Close = .6;
        final double Grabber_Open = .05;
        DcMotor Intake;
        Intake = hardwareMap.dcMotor.get("Intake");
        Intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DcMotor ShooterMotor;
        ShooterMotor = hardwareMap.dcMotor.get("ShooterMotor");
        ShooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        DcMotor Transfer;
        Transfer = hardwareMap.dcMotor.get("Transfer");
        Transfer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        initializeComponentsAutonomous();
        waitForStart();

        gyro.resetAngle();
        MoveUntilEncoderGYRO(73,135,.6,0);//149.........153
        sleep(100);
        TurnAbsolute(0,.3,.6);
        sleep(200);
        MoveUntilRangeLbothAc(7.5,90,.6,0);
        rampShooter(.545);   //58.........53
        TurnAbsolute(-16.5,.3,.6);//-15
        sleep(2000);
        moveTransfer();
        sleep(75);
        stopTransfer();
        sleep(150);
        TurnAbsolute(-18.5,.3,.6); //-22
        sleep(600);
        moveTransfer();
        sleep(70);
        stopTransfer();
        sleep(150);
        TurnAbsolute(-23,.32,.6);//-19
        //sleep(800);
        //reverseTransfer();
        sleep(650);
        moveTransfer();
        sleep(400);
        stopTransfer();
        stopShooter();
        TurnAbsolute(0,.3,.6);
        sleep(100);
        MoveUntilEncoderGYRO(5,225,1,0);
        MoveUntilRangeRbothAc(24.5,270,.5,0);
        sleep(200);
        startIntake();
        moveTransfer();
        rampShooter(-.15);
        MoveUntilEncoderGYRO(46,0,.6,0);
        stopIntake();
        reverseTransfer();
        stopShooter();
        sleep(400);
        stopTransfer();
        MoveUntilEncoderGYRO(24,180,.85,0);
        sleep(150);
        TurnAbsolute(-7,.3,.6);
        rampShooter(.50);
        sleep(800);
        moveTransfer();
        startIntake();
        sleep(900);
        stopTransfer();
        stopShooter();
        stopIntake();
        TurnAbsolute(0,.3,.6);
        MoveUntilRangeFbothAc(19,180,.65,0);
        MoveUntilRangeRbothAc(8,270,.6,0);
        dropWobble();
        sleep(100);
        grabber.setPosition(Grabber_Open);
        MoveUntilEncoderGYRO(5,270,1,0);
        MoveUntilEncoderGYRO(12,0,1,0);
    stopMotors();

        if(!opModeIsActive())
        {
            return;
        }

        return;
    }

}
