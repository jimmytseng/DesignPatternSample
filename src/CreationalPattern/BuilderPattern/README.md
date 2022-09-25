# 使用時間
當創立一個物件時處在一個複雜的條件，此物件可能產生多個建構子。此時可考慮藉由build class來創建該物件。
# 如何使用
![BuilderPattern](BuilderPattern.jpg)  
# JDK Example
• java.lang.StringBuilder#append() (unsynchronized)  
• java.lang.StringBuffer#append() (synchronized)  
• java.nio.ByteBuffer#put() (also on CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)  
• javax.swing.GroupLayout.Group#addComponent()  
• All implementations of java.lang.Appendable