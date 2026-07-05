# Security Policy

## Supported Versions

This repository (`Aruisop/LC`) is a personal collection of LeetCode problem
solutions written in Java. It is not a released software package, library,
or application with version tags, and it does not have formal releases or
ongoing dependency management.

As such, there are no historical "versions" to support in the traditional
sense; only the current state of the `main` branch is maintained.

| Version           | Supported          |
| ------------------ | ------------------ |
| `main` (latest)    | :white_check_mark: |
| Older commits/forks | :x:                |

If this repository begins publishing tagged releases or packages in the
future, this table will be updated to reflect which versions receive
security fixes.

## Reporting a Vulnerability

Since this repo contains algorithmic solutions rather than a deployed
service, "vulnerabilities" here would most likely relate to things like:

- Malicious or unsafe code accidentally committed (e.g. unsafe file I/O,
  unvetted third-party snippets)
- Supply-chain issues in any build tooling or dependencies used to compile/run
  the solutions
- Exposed secrets, credentials, or personal information committed by mistake

If you discover a security issue of this kind:

1. **Do not open a public GitHub issue** describing the vulnerability in
   detail, to avoid premature disclosure.
2. Report it privately by opening a [GitHub Security Advisory](https://github.com/Aruisop/LC/security/advisories/new)
   for this repository, or by contacting the maintainer directly through
   their GitHub profile ([@Aruisop](https://github.com/Aruisop)).
3. Please include:
   - A description of the issue and where it was found (file/path/commit)
   - Steps to reproduce, if applicable
   - Any suggested fix, if you have one

**What to expect:**

- Acknowledgement of your report within **7 days**.
- An initial assessment and, if applicable, a fix timeline within **14 days**
  of acknowledgement.
- If the issue is confirmed, a fix will be committed and you will be
  credited (unless you prefer to remain anonymous).
- If the report is declined (e.g. not applicable to this repo's scope), you
  will receive an explanation of why.

Thank you for helping keep this project safe.
