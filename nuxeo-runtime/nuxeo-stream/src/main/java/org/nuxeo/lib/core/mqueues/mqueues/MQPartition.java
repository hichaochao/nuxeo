/*
 * (C) Copyright 2017 Nuxeo SA (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     bdelbosc
 */
package org.nuxeo.lib.core.mqueues.mqueues;

/**
 * A tuple to store a MQueue name and the partition index.
 *
 * @since 9.2
 */
public class MQPartition {
    protected final String name;
    protected final int partition;

    public MQPartition(String name, int partition) {
        this.name = name;
        this.partition = partition;
    }

    /**
     * Returns the MQueue's name
     */
    public String name() {
        return name;
    }

    /**
     * Returns the partition index.
     */
    public int partition() {
        return partition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MQPartition that = (MQPartition) o;

        if (partition != that.partition) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + partition;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s-%02d", name, partition);
    }

    public static MQPartition of(String name, int partition) {
        return new MQPartition(name, partition);
    }
}