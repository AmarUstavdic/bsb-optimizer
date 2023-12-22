#!/bin/bash

SOURCE_DIR="/home/lilwizzz/Desktop/batalja-bot/src"
OPTIMIZER_DIR="/home/lilwizzz/Desktop/optimizer"
BOT_DIR="$OPTIMIZER_DIR/bot"
PLAYER_DIRS=("$OPTIMIZER_DIR/Player1" "$OPTIMIZER_DIR/Player2" "$OPTIMIZER_DIR/Player3" "$OPTIMIZER_DIR/Player4")

for player_dir in "${PLAYER_DIRS[@]}"; do
    # shellcheck disable=SC2115
    rm -rf "$player_dir"/*
done

cp "$SOURCE_DIR"/* "$BOT_DIR"
javac "$BOT_DIR"/*.java

for player_dir in "${PLAYER_DIRS[@]}"; do
    cp "$BOT_DIR"/*.class "$player_dir"
done
