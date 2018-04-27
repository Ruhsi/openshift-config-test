FROM jboss/wildfly
MAINTAINER <christoph.ruhsam@gepardec.com>

LABEL name="ConfigTest"

ENV CONFIG_RUN_USER conf
ENV CONFIG_RUN_GROUP 0
ENV CONFIG_HOME_RUN_USER /home/${CONFIG_RUN_USER}

USER root

RUN mkdir -p ${CONFIG_HOME_RUN_USER} \
    && useradd \
      --home-dir ${CONFIG_HOME_RUN_USER} \
      --shell /sbin/nologin \
      -g ${CONFIG_RUN_GROUP} \
      -u 1001 \
      ${CONFIG_RUN_USER}

USER ${CONFIG_RUN_USER}
