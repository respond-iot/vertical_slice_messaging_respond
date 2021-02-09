# Deploying

This `process_repository`, `selfhealing`, as well as a mqtt server can be deployed automatically using ansible and
docker.

For deploying a local test environment vagrant and virtualbox can be used.

## Deploying
The root directory of this repository contains a `playbook.yml` ansible playbook, which can be used for deployment.
It defines runs on three hosts called `broker`, `process_repository` and `selfhealing` and deploys the corresponding
components on them. You will need an inventory file defining at least one of those hosts.

For this you need a `config.yml` file in the root directory of this repository. It need to contain all the keys
contained in `config.yml.example`.

Note that this playbook requires ansible to use `python3` on all hosts. This can be set in the inventory file using
`ansible_python_interpreter=python3` after the host line.

The playbook uses roles from the `roles` folder to install docker and build and run containers on the remote machines.
While containers are built on the remote machine the executable jar is built on localhost, to prevent having to install
java/kotlin on the remote.

The playbook can be run using `ansible-playbook -i <inventory_file> playbook.yml`.

## Deploying test environment
In the root directory of this repository run `vagrant up`. This should start up two virtual machines with
`process_repository` running on one and `selfhealing` on the other. This also uses `config.yml`

Note that this still uses the `deploy.yml` files from the project folders instead of `playbook.yml` from the root folder
and should be changed to use that one instead.

## CI
Github Actions is used as a CI and automatically builds and deploys both `process_repository` and `selfhealing`. The
broker is deployed manually by HsKA and not handled by this repository.

The CI uses credentials stored in Github secrets to connect to the server.  
It also uses a config file from the `deployment_secrets` folder, which has been encrypted using the `encrypt_secrets.sh`
script in the root directory. The decryption password is also stored as a Github secret.  
This is meant for large secrets. Currently the config is so small, that it could also be stored directly as a secret.