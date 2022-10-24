### Installing Red Hat OpenJDK 1.11 on Linux

> **_NOTE:_** Root / Wheel privileges are required to perform the installation

#### Red Hat Enterprise Linux Installation

- Run the yum command, specifying the package you want to install:
```shell
$ sudo yum install java-11-openjdk-devel
```
- Check that the installation works:
```shell
$ javac -version
```

#### Other Versions of Linux

- Navigate to [Red Hat Developer - OpenJDK Download](https://developers.redhat.com/products/openjdk/download)
- Find the most recent build of the **jdk-11.XXX.XXX-x64 MSI** where **XXX.XXX** is the most recent build and select the **Download** link
- Locate the directory to which the **MSI Installer** file was downloaded and execute the file

> **_NOTE:_** Windows may display a confirmation dialog confirming execution of a file that may contain malicious code.
> ![Windows Security Question](images/java1.11-msi-possible_permission.png "Windows Security Question")
> - Select ***OK*** to continue.

![Windows Security Question](images/java1.11-msi-setup_1.png "Welcome Screen")

- Select the ***Next*** button on the installer welcome screen to continue.

![Windows Security Question](images/java1.11-msi-setup_2.png "License Agreement")

- Accept the license agreement by placing a tick in the ***I accept the terms in the License Agreement*** box.
- Select the ***Next*** button on the installer license agreement screen to continue.

![Windows Security Question](images/java1.11-msi-setup_3.png "Custom Setup")

- The **Custom Setup** window allows for customization of the JDK installation. The defaults should be sufficient.
- Select the ***Next*** button on the installer custom setup screen to continue.

![Windows Security Question](images/java1.11-msi-setup_4.png "Confirmation")

- Select the ***Install*** button on the installer confirmation screen to install the OpenJDK.

![Windows Security Question](images/java1.11-msi-setup_5.png "Completed")

- Once the installation has completed successfully click the  ***Finish*** button to complete the installation.