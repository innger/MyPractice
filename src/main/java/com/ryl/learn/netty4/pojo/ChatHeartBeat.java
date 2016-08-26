// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: com/ryl/learn/netty4/pojo/chatheartbeat.proto

package com.ryl.learn.netty4.pojo;

public final class ChatHeartBeat {
  private ChatHeartBeat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface HeartBeatPingOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.ryl.learn.netty4.pojo.HeartBeatPing)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes ping = 1;</code>
     */
    boolean hasPing();
    /**
     * <code>required bytes ping = 1;</code>
     */
    com.google.protobuf.ByteString getPing();
  }
  /**
   * Protobuf type {@code com.ryl.learn.netty4.pojo.HeartBeatPing}
   */
  public static final class HeartBeatPing extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.ryl.learn.netty4.pojo.HeartBeatPing)
      HeartBeatPingOrBuilder {
    // Use HeartBeatPing.newBuilder() to construct.
    private HeartBeatPing(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private HeartBeatPing(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final HeartBeatPing defaultInstance;
    public static HeartBeatPing getDefaultInstance() {
      return defaultInstance;
    }

    public HeartBeatPing getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private HeartBeatPing(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              ping_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing.class, com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing.Builder.class);
    }

    public static com.google.protobuf.Parser<HeartBeatPing> PARSER =
        new com.google.protobuf.AbstractParser<HeartBeatPing>() {
      public HeartBeatPing parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new HeartBeatPing(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<HeartBeatPing> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int PING_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString ping_;
    /**
     * <code>required bytes ping = 1;</code>
     */
    public boolean hasPing() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes ping = 1;</code>
     */
    public com.google.protobuf.ByteString getPing() {
      return ping_;
    }

    private void initFields() {
      ping_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasPing()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, ping_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, ping_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.ryl.learn.netty4.pojo.HeartBeatPing}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.ryl.learn.netty4.pojo.HeartBeatPing)
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPingOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing.class, com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing.Builder.class);
      }

      // Construct using com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        ping_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_descriptor;
      }

      public com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing getDefaultInstanceForType() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing.getDefaultInstance();
      }

      public com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing build() {
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing buildPartial() {
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing result = new com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.ping_ = ping_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing) {
          return mergeFrom((com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing other) {
        if (other == com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing.getDefaultInstance()) return this;
        if (other.hasPing()) {
          setPing(other.getPing());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasPing()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPing) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString ping_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes ping = 1;</code>
       */
      public boolean hasPing() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes ping = 1;</code>
       */
      public com.google.protobuf.ByteString getPing() {
        return ping_;
      }
      /**
       * <code>required bytes ping = 1;</code>
       */
      public Builder setPing(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        ping_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes ping = 1;</code>
       */
      public Builder clearPing() {
        bitField0_ = (bitField0_ & ~0x00000001);
        ping_ = getDefaultInstance().getPing();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.ryl.learn.netty4.pojo.HeartBeatPing)
    }

    static {
      defaultInstance = new HeartBeatPing(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.ryl.learn.netty4.pojo.HeartBeatPing)
  }

  public interface HeartBeatPongOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.ryl.learn.netty4.pojo.HeartBeatPong)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes pong = 1;</code>
     */
    boolean hasPong();
    /**
     * <code>required bytes pong = 1;</code>
     */
    com.google.protobuf.ByteString getPong();
  }
  /**
   * Protobuf type {@code com.ryl.learn.netty4.pojo.HeartBeatPong}
   */
  public static final class HeartBeatPong extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.ryl.learn.netty4.pojo.HeartBeatPong)
      HeartBeatPongOrBuilder {
    // Use HeartBeatPong.newBuilder() to construct.
    private HeartBeatPong(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private HeartBeatPong(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final HeartBeatPong defaultInstance;
    public static HeartBeatPong getDefaultInstance() {
      return defaultInstance;
    }

    public HeartBeatPong getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private HeartBeatPong(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              pong_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong.class, com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong.Builder.class);
    }

    public static com.google.protobuf.Parser<HeartBeatPong> PARSER =
        new com.google.protobuf.AbstractParser<HeartBeatPong>() {
      public HeartBeatPong parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new HeartBeatPong(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<HeartBeatPong> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int PONG_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString pong_;
    /**
     * <code>required bytes pong = 1;</code>
     */
    public boolean hasPong() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes pong = 1;</code>
     */
    public com.google.protobuf.ByteString getPong() {
      return pong_;
    }

    private void initFields() {
      pong_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasPong()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, pong_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, pong_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.ryl.learn.netty4.pojo.HeartBeatPong}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.ryl.learn.netty4.pojo.HeartBeatPong)
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPongOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong.class, com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong.Builder.class);
      }

      // Construct using com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        pong_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_descriptor;
      }

      public com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong getDefaultInstanceForType() {
        return com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong.getDefaultInstance();
      }

      public com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong build() {
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong buildPartial() {
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong result = new com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.pong_ = pong_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong) {
          return mergeFrom((com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong other) {
        if (other == com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong.getDefaultInstance()) return this;
        if (other.hasPong()) {
          setPong(other.getPong());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasPong()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.ryl.learn.netty4.pojo.ChatHeartBeat.HeartBeatPong) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString pong_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes pong = 1;</code>
       */
      public boolean hasPong() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes pong = 1;</code>
       */
      public com.google.protobuf.ByteString getPong() {
        return pong_;
      }
      /**
       * <code>required bytes pong = 1;</code>
       */
      public Builder setPong(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        pong_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes pong = 1;</code>
       */
      public Builder clearPong() {
        bitField0_ = (bitField0_ & ~0x00000001);
        pong_ = getDefaultInstance().getPong();
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.ryl.learn.netty4.pojo.HeartBeatPong)
    }

    static {
      defaultInstance = new HeartBeatPong(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.ryl.learn.netty4.pojo.HeartBeatPong)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n-com/ryl/learn/netty4/pojo/chatheartbea" +
      "t.proto\022\031com.ryl.learn.netty4.pojo\"\035\n\rHe" +
      "artBeatPing\022\014\n\004ping\030\001 \002(\014\"\035\n\rHeartBeatPo" +
      "ng\022\014\n\004pong\030\001 \002(\014B*\n\031com.ryl.learn.netty4" +
      ".pojoB\rChatHeartBeat"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_ryl_learn_netty4_pojo_HeartBeatPing_descriptor,
        new java.lang.String[] { "Ping", });
    internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_ryl_learn_netty4_pojo_HeartBeatPong_descriptor,
        new java.lang.String[] { "Pong", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
