# Justify CLI
[![Apache 2.0 License](https://img.shields.io/:license-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Latest release](https://img.shields.io/github/release/leadpony/justify-cli.svg)](https://github.com/leadpony/justify-cli/releases/latest)
[![Build Status](https://travis-ci.org/leadpony/justify-cli.svg?branch=master)](https://travis-ci.org/leadpony/justify-cli)

Justify CLI is a command-line utility for validating JSON documents based on the JSON Schema specification.

## Downloads

Check the [Releases] page to get the latest distribution.

This software requires Java 8 or higher.

## Usage

For validating a JSON instance against a JSON schema:

```bash
$ justify.sh <path/to/JSON/schema> <path/to/JSON/instance>
```

For validating a JSON schema only:

```bash
$ justify.sh <path/to/JSON/schema>
```

## Copyright Notice
Copyright &copy; 2018-2019 the Justify authors. This software is licensed under [Apache License, Versions 2.0][Apache 2.0 License].

[Apache 2.0 License]: https://www.apache.org/licenses/LICENSE-2.0
[Justify]: https://github.com/leadpony/justify
[Releases]: https://github.com/leadpony/justify-cli/releases/latest
