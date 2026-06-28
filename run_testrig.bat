echo RUNNING UPDATED VERSION
pause

@echo off
REM =====================================================
REM ANTLR TestRig Runner (FIXED VERSION)
REM =====================================================

setlocal enabledelayedexpansion

REM ---- Project paths ----
set PROJECT_DIR=C:\sem7\SPR\sprachkonzepte
set TEST_DIR=%PROJECT_DIR%\test_examples
set TARGET_DIR=%PROJECT_DIR%\target\classes
set LIB_DIR=%USERPROFILE%\.m2\repository\org\antlr\antlr4-runtime\4.13.2

REM IMPORTANT: use ANTLR COMPLETE JAR (required for TestRig GUI)
set ANTLR_JAR=C:\sem7\SPR\lib\antlr-4.13.2-complete.jar
REM ---- Validate input ----
if "%1"=="" (
    echo Usage: run_testrig.bat [1^|2^|3]
    echo.
    echo Example:
    echo   run_testrig.bat 1
    exit /b 1
)

set EXAMPLE=%1
set INPUT_FILE=%TEST_DIR%\example%EXAMPLE%.txt

if not exist "%INPUT_FILE%" (
    echo ERROR: Input file does not exist:
    echo %INPUT_FILE%
    exit /b 1
)

if not exist "%ANTLR_JAR%" (
    echo ERROR: ANTLR JAR not found:
    echo %ANTLR_JAR%
    exit /b 1
)

if not exist "%TARGET_DIR%" (
    echo ERROR: Build folder not found:
    echo %TARGET_DIR%
    exit /b 1
)

REM ---- Run ----
echo =====================================================
echo Starting ANTLR TestRig
echo File: %INPUT_FILE%
echo =====================================================
echo.

cd /d "%PROJECT_DIR%"

java -cp "%TARGET_DIR%;%ANTLR_JAR%" ^
org.antlr.v4.gui.TestRig ^
aufgabe2.aufgabe2ab.gen.bestellungs ^
bestellung ^
-gui ^
"%INPUT_FILE%"

echo.
echo =====================================================
echo Done
echo =====================================================
pause