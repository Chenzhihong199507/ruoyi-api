/*
 * MIT License
 *
 * Copyright (c) 2023 OrdinaryRoad
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: douyin_cmd_msg.proto

package tech.ordinaryroad.live.chat.client.douyin.protobuf;

public final class Douyin_cmd_msgProto {
  private Douyin_cmd_msgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tech_ordinaryroad_live_chat_client_douyin_protobuf_douyin_cmd_msg_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tech_ordinaryroad_live_chat_client_douyin_protobuf_douyin_cmd_msg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024douyin_cmd_msg.proto\0222tech.ordinaryroa" +
      "d.live.chat.client.douyin.protobuf\"\250\001\n\016d" +
      "ouyin_cmd_msg\022\016\n\006method\030\001 \001(\t\022\017\n\007payload" +
      "\030\002 \001(\014\022\016\n\006msg_id\030\003 \001(\003\022\020\n\010msg_type\030\004 \001(\005" +
      "\022\016\n\006offset\030\005 \001(\003\022\027\n\017need_wrds_store\030\006 \001(" +
      "\010\022\024\n\014wrds_version\030\007 \001(\003\022\024\n\014wrds_sub_key\030" +
      "\010 \001(\tBQ\n2tech.ordinaryroad.live.chat.cli" +
      "ent.douyin.protobufB\023Douyin_cmd_msgProto" +
      "P\001\242\002\003GPBb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tech_ordinaryroad_live_chat_client_douyin_protobuf_douyin_cmd_msg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tech_ordinaryroad_live_chat_client_douyin_protobuf_douyin_cmd_msg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tech_ordinaryroad_live_chat_client_douyin_protobuf_douyin_cmd_msg_descriptor,
        new java.lang.String[] { "Method", "Payload", "MsgId", "MsgType", "Offset", "NeedWrdsStore", "WrdsVersion", "WrdsSubKey", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
