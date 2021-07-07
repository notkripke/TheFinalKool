package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Components.VisionPipeline;
import org.firstinspires.ftc.teamcode.GorillabotsCentral;

@Autonomous(group = "test", name = "RegionalsAuto")

public class RegionalsAuto extends GorillabotsCentral {

    public void runOpMode() throws InterruptedException {

        initializeComponentsAutonomous();
        DcMotor Intake;
        Intake = hardwareMap.dcMotor.get("Intake");
        Intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DcMotor ShooterMotor;
        ShooterMotor = hardwareMap.dcMotor.get("ShooterMotor");
        ShooterMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        DcMotor Transfer;
        Transfer = hardwareMap.dcMotor.get("Transfer");
        Transfer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        webcam.openCameraDevice();
        webcam.setPipeline(pipeline);
        startVisionProcessing();
        gyro.resetAngle();
        while (!isStarted() && !isStopRequested()){
            pipeline.getPos();
            telemetry.addData("Gyro",gyro.getAngle());
            telemetry.addData("Rings", pipeline.getPos());
            telemetry.addData("# Detected", pipeline.getAnalysis());
            telemetry.update();}

        waitForStart();

        switch (pipeline.getPos()) {

            case 0: //Zero rings detected path. Edits can be made in Gorillabots Central
                runNewTrack0();
                break;

            case 1: //One ring detected path
                telemetry.addData("Track", "1");
                telemetry.update();
                runNewTrack1();
                break;

            case 4: //Four rings detected path.
                runNewTrack4();
                sleep(5000);
                break;



        }

        return;
    }

}
