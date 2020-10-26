# Jackson Encryptor Serializer
Json end-node value encryption using JSON Views, and a custom jackson serializer

### Dependencies
- Spring Boot
- Lombok plugin

Using the same POJO and two different json-view endpoints.
The serializer uses hashing, bit it can be changed to an encryption algorithm.

The /not-hashed end point will return:

```
{
    "name": "Rei",
    "job": "Developer",
    "age": 25,
    "employer": {
        "name": "X"
    }
}
```

The /hashed end point will return: 

```
{
    "name": "d8b97fdf0b45008f061e540a44748d2b64692e0749d4d8cd787407d5edae846c",
    "job": "3fb7b39416f1d067268747fc214494d759d2609f863ace1a8a76705618d5c80b",
    "age": "b7a56873cd771f2c446d369b649430b65a756ba278ff97ec81bb6f55b2e73569",
    "employer": {
        "name": "4b68ab3847feda7d6c62c1fbcbeebfa35eab7351ed5e78f4ddadea5df64b8015"
    }
}
```
