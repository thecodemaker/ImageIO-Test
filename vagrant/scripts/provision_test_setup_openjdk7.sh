#!/bin/sh

sudo apt-get -y purge openjdk-6-jdk

sudo apt-get -y update

JAVA_VERSION="openjdk-7-jdk"

echo "[vagrant provisioning] Installing Java..."

sudo apt-get -y install $JAVA_VERSION

export JAVA_HOME=/usr/lib/jvm/$JAVA_VERSION

##### PROVISION CHECK #####

# Create .provision_check for the script to check on during a next vargant up.
echo "[vagrant provisioning] Creating .provision_check file..."
touch .provision_check