#!/bin/bash

rm *.class
rm nohup.out

rm imageio/images_1px/1_PIXEL_*.jpg
for i in {1..10}
do
    cp imageio/images_1px/1_PIXEL.jpg imageio/images_1px/1_PIXEL_$i.jpg
done

javac App.java

nohup java App 2>&1 &
nohup java App 2>&1 &

#cd /vagrant_data
#less -h 20 nohup.out