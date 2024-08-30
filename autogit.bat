@echo off
setlocal enabledelayedexpansion

REM 获取命令行参数
if "%~1"=="" (
    echo Usage: %~nx0 folderName
    exit /b 1
)

set "folderName=%~1"

REM 检查文件夹是否存在
if not exist "%folderName%" (
    echo Folder "%folderName%" does not exist.
    exit /b 1
)

REM 获取当前目录下的所有 .目标语言的文件
for /f "delims=" %%i in ('dir /b "%folderName%\*.%folderName%" 2^>nul') do (
    set "fileName=%%i"
    REM 检查文件是否未被 Git 托管
    git ls-files --error-unmatch "%folderName%\%%i" 2>nul
    if errorlevel 1 (
        REM 提取文件名中的前缀
        for /f "tokens=1 delims=." %%a in ("%%i") do (
            set "prefix=%%a"
        )
        REM 执行 git add 命令
        git add "%folderName%\%%i"
        if errorlevel 1 (
            echo Failed to add file "%folderName%\%%i"
            exit /b 1
        )
        REM 执行 git commit 命令
        git commit -m "leetcode.!prefix!-!folderName!"
        if errorlevel 1 (
            echo Failed to commit file "%folderName%\%%i"
            exit /b 1
        )
    )
)

endlocal