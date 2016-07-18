#!/usr/bin/python2.7

f = open("mcpi.txt")

line = f.readline()
mcpiArgs = line.split(" ")
print './McPi/' + mcpiArgs[2].strip() + '.py',
f.close
