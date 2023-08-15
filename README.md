### Before committing/pushing

- Run `mvn checkstyle:checkstyle`
- If build fails with `An error has occurred in Checkstyle report generation.: Failed during checkstyle execution` , fix
  styling issues by:
    - Select the file with error and right-click on it.
    - Select `Reformat Code`.
    - Choose `Optimize imports, rearrange entries and cleanup code`.
    - Click on the `OK` button.
- If checkstyle build is successful, you can commit your code and create PR.

### Run application
- Run your SpringBootApplication and go to url: localhost:8088/dailyworkout