# Getting Started

## Generate a keystore to java applications

Generate the allanweber.p12 using certificate and private-key

```bash
openssl pkcs12 -export -in certificate.crt -inkey private.key -name allanweber -out allanweber.p12
password: 123456
keytool -list -v -keystore allanweber.p12
```

the result must contain a entry with PrivateKeyEntry

```bash
Alias name: allanweber
Creation date: Apr 28, 2022
Entry type: PrivateKeyEntry
Certificate chain length: 1
```
