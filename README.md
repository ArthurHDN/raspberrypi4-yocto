## How to build

```bash
kas-container build kas/rpi4.yml
```

## How to flash

1. Find the .wic file under build/tmp*/deploy/images
2. Plug the Raspberry SD card to the computer
3. Identify the device for the SD card, e.g. `/dev/sda`
4. ```bash
   sudo dd if=core-image-minimal-raspberrypi4-64.rootfs.wic of=/dev/sda bs=4M status=progress conv=fsync
   ```
