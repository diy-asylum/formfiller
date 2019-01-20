#!/bin/bash
set -euo pipefail
IFS=$'\n\t'
if [[ ! -d libsodium-1.0.17 ]]; then
    curl https://download.libsodium.org/libsodium/releases/libsodium-1.0.17.tar.gz > libsodium-1.0.17.tar.gz
    tar -xvf libsodium-1.0.17.tar.gz
fi
cd libsodium-1.0.17
./configure
make && make check
make install