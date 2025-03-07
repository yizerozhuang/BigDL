#
# Copyright 2016 The BigDL Authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
from unittest import TestCase

import pytest

import bigdl.orca.ray.utils as rutils


class TestUtil(TestCase):

    def test_resource_to_bytes(self):
        assert 10 == rutils.resource_to_bytes("10b")
        assert 10000 == rutils.resource_to_bytes("10k")
        assert 10000000 == rutils.resource_to_bytes("10m")
        assert 10000000000 == rutils.resource_to_bytes("10g")


if __name__ == "__main__":
    pytest.main([__file__])
