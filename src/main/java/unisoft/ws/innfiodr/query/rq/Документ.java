
package unisoft.ws.innfiodr.query.rq;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="����">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="��������">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="1"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="�������">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                         &lt;enumeration value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *                 &lt;attribute name="��������" use="required" type="{http://ws.unisoft/INNFIODR/Query/Rq}�������" />
 *                 &lt;attribute name="�������" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="60"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="���" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="60"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="��������" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="5"/>
 *             &lt;enumeration value="4.01"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="���������">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="36"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "\u0441\u0432\u0424\u041b"
})
@XmlRootElement(name = "\u0414\u043e\u043a\u0443\u043c\u0435\u043d\u0442")
public class �������� {

    @XmlElement(name = "\u0421\u0432\u0424\u041b", required = true)
    protected ��������.���� ����;
    @XmlAttribute(name = "\u0412\u0435\u0440\u0441\u0424\u043e\u0440\u043c", required = true)
    protected String ��������;
    @XmlAttribute(name = "\u0418\u0434\u0417\u0430\u043f\u0440\u043e\u0441\u041f")
    protected String ���������;

    /**
     * Gets the value of the ���� property.
     * 
     * @return
     *     possible object is
     *     {@link ��������.���� }
     *     
     */
    public ��������.���� get����() {
        return ����;
    }

    /**
     * Sets the value of the ���� property.
     * 
     * @param value
     *     allowed object is
     *     {@link ��������.���� }
     *     
     */
    public void set����(��������.���� value) {
        this.���� = value;
    }

    /**
     * Gets the value of the �������� property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get��������() {
        return ��������;
    }

    /**
     * Sets the value of the �������� property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set��������(String value) {
        this.�������� = value;
    }

    /**
     * Gets the value of the ��������� property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get���������() {
        return ���������;
    }

    /**
     * Sets the value of the ��������� property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set���������(String value) {
        this.��������� = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="��������">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="1"/>
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="�������">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *               &lt;enumeration value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/choice>
     *       &lt;attribute name="��������" use="required" type="{http://ws.unisoft/INNFIODR/Query/Rq}�������" />
     *       &lt;attribute name="�������" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="60"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="���" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="60"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "\u043e\u0442\u0447\u0435\u0441\u0442\u0432\u043e",
        "\u043f\u0440\u0438\u0437\u041e\u0442\u0447"
    })
    public static class ���� {

        @XmlElement(name = "\u041e\u0442\u0447\u0435\u0441\u0442\u0432\u043e")
        protected String ��������;
        @XmlElement(name = "\u041f\u0440\u0438\u0437\u041e\u0442\u0447")
        protected String �������;
        @XmlAttribute(name = "\u0414\u0430\u0442\u0430\u0420\u043e\u0436\u0434", required = true)
        protected String ��������;
        @XmlAttribute(name = "\u0424\u0430\u043c\u0438\u043b\u0438\u044f", required = true)
        protected String �������;
        @XmlAttribute(name = "\u0418\u043c\u044f", required = true)
        protected String ���;

        /**
         * Gets the value of the �������� property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get��������() {
            return ��������;
        }

        /**
         * Sets the value of the �������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set��������(String value) {
            this.�������� = value;
        }

        /**
         * Gets the value of the ������� property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get�������() {
            return �������;
        }

        /**
         * Sets the value of the ������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set�������(String value) {
            this.������� = value;
        }

        /**
         * Gets the value of the �������� property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get��������() {
            return ��������;
        }

        /**
         * Sets the value of the �������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set��������(String value) {
            this.�������� = value;
        }

        /**
         * Gets the value of the ������� property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get�������() {
            return �������;
        }

        /**
         * Sets the value of the ������� property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set�������(String value) {
            this.������� = value;
        }

        /**
         * Gets the value of the ��� property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get���() {
            return ���;
        }

        /**
         * Sets the value of the ��� property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set���(String value) {
            this.��� = value;
        }

    }

}
