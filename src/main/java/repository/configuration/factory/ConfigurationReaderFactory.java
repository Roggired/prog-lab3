package repository.configuration.factory;

import jsonreader.JSONReader;
import repository.configuration.ConfigurationReader;
import repository.configuration.JSONDBConfigurationReader;

public interface ConfigurationReaderFactory {
    ConfigurationReader create(String fullFileName, JSONReader<JSONDBConfigurationReader.NameIdPair> jsonReader);
}
