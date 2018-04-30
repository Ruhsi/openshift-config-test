#!/bin/bash
# author: Thomas Herzog
# date: 24/01/12

# Execute in script dir
cd $(dirname ${0})

source ../properties/.config-source

function createIs() {
  oc new-app -f ../templates/is.yml \
    -p "SERVICE_NAME=${SERVICE_NAME}"
} # createIs

function createBc() {
  oc new-app -f ../templates/bc.yml \
    -p "SERVICE_NAME=${SERVICE_NAME}" \
    -p "GIT_URL=https://github.com/Ruhsi/openshift-config-test" \
    -p "GIT_REF=master"
} # createBc

function createDc() {
  oc new-app -f ../templates/dc.yml \
    -p "SERVICE_NAME=${SERVICE_NAME}"
} # createDc

function createSvc() {
  oc new-app -f ../templates/svc.yml \
    -p "SERVICE_NAME=${SERVICE_NAME}"
} # createSvc

function createRoute() {
  oc new-app -f ../templates/route.yml \
    -p "SERVICE_NAME=${SERVICE_NAME}" \
    -p "HOST_NAME="
} # createRoute

function createAll() {
    createIs
    createBc
    createDc
    createSvc
    createRoute
}

function deleteIs() {
  oc delete is/${SERVICE_NAME}
}

function deleteBc() {
  oc delete bc/${SERVICE_NAME}
}

function deleteDc() {
  oc delete dc/${SERVICE_NAME}
}

function deleteSvc() {
  oc delete service/${SERVICE_NAME}
}

function deleteRoute() {
  oc delete route/${SERVICE_NAME}
}

function deleteAll() {
    deleteIs
    deleteBc
    deleteDc
    deleteSvc
    deleteRoute
}

function recreateIs(){
    deleteIs
    createIs
}

function recreateBc(){
    deleteBc
    createBc
}

function recreateDc(){
    deleteDc
    createDc
}

function recreateSvc(){
    deleteSvc
    createSvc
}

function recreateRoute(){
    deleteRoute
    createRoute
}

function recreateAll(){
    deleteAll
    createAll
}

case ${1} in
   createIs|createBc|createDc|createSvc|createRoute|createAll|deleteIs|deleteBc|deleteDc|deleteSvc|deleteRoute|deleteAll|recreateIs|recreateBc|recreateDc|recreateSvc|recreateRoute|recreateAll)
      ${1}
      ;;
   *)
     echo "${0} [createIs|createBc|createDc|createSvc|createRoute|createAll|deleteIs|deleteBc|deleteDc|deleteSvc|deleteRoute|deleteAll|recreateIs|recreateBc|recreateDc|recreateSvc|recreateRoute|recreateAll]"
     exit 1
      ;;
esac
