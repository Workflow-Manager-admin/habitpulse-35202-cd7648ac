#!/bin/bash
cd /home/kavia/workspace/code-generation/habitpulse-35202-cd7648ac/habitpulse
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

